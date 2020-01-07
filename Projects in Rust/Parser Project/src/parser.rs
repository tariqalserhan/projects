// Here is where the various combinators are imported. You can find all the combinators here:
// https://docs.rs/nom/5.0.1/nom/
// If you want to use it in your parser, you need to import it here. I've already imported a couple.

use nom::{
  IResult,
  branch::alt,
  combinator::opt,
  sequence::delimited,
  multi::{many1, many0,separated_list},
  bytes::complete::{tag},
  character::complete::{alphanumeric1, digit1,multispace0},
};

// Here are the different node types. You will use these to make your parser and your grammar.
// You may add other nodes as you see fit, but these are expected by the runtime.

#[derive(Debug, Clone)]
pub enum Node {
  Program { children: Vec<Node> },
  Statement { children: Vec<Node> },
  FunctionReturn { children: Vec<Node> },
  FunctionDefine { children: Vec<Node> },
  FunctionArguments { children: Vec<Node> },
  FunctionStatements { children: Vec<Node> },
  Expression { children: Vec<Node> },
  MathExpression {name: String, children: Vec<Node> },
  FunctionCall { name: String, children: Vec<Node> },
  VariableDefine { children: Vec<Node> },
  Number { value: i32 },
  Bool { value: bool },
  Identifier { value: String },
  String { value: String },
}

pub fn identifier(input: &str) -> IResult<&str, Node> {
  let (input, result) = alphanumeric1(input)?;              // Consume at least 1 alphanumeric character. The ? automatically unwraps the result if it's okay and bails if it is an error.
  Ok((input, Node::Identifier{ value: result.to_string()})) // Return the now partially consumed input, as well as a node with the string on it.
}

// Define an integer number
pub fn number(input: &str) -> IResult<&str, Node> {
  let (input, result) = digit1(input)?;                     // Consume at least 1 digit 0-9
  let number = result.parse::<i32>().unwrap();              // Parse the string result into a usize
  Ok((input, Node::Number{ value: number}))                 // Return the now partially consumed input with a number as well
}

pub fn boolean(input: &str) -> IResult<&str, Node> {

  let (input, result) = alt((tag("true"),tag("false")))(input)?;
  let output = if (result == "true") {
    true } else {
       false};
  Ok((input, Node::Bool{ value: output}))
  
}

pub fn string(input: &str) -> IResult<&str, Node> {

  let (input, _) = multispace0(input)?;
  let (input, _) = tag("\"")(input)?; 
  let (input, output) = many1(alt((alphanumeric1,tag(" "))))(input)?;
  let (input, _) = tag("\"")(input)?;
  Ok((input, Node::String{value: output.join("")}))

}

pub fn function_call(input: &str) -> IResult<&str, Node> {

  let (input, _) = multispace0(input)?;
  let (input, function) = alphanumeric1(input)?; 
  let (input, _) = tag("(")(input)?;
  let (input, output) = many0(arguments)(input)?;
  let (input, _) = tag(")")(input)?;
  Ok((input, Node::FunctionCall{name: function.to_string(), children: output}))

}


pub fn parenthetical_expression(input: &str) -> IResult<&str, Node> {

     delimited(tag("("), math_expression, tag(")"))(input)
  
  }

pub fn l4(input: &str) -> IResult<&str, Node> {
  alt((function_call, number, identifier, parenthetical_expression))(input)
}

pub fn l3_infix(input: &str) -> IResult<&str, Node> {

  let (input, _) = many0(tag(" "))(input)?;
  let (input, op) = tag("^")(input)?;
  let (input, _) = many0(tag(" "))(input)?;
  let (input, args) = l4(input)?;
  Ok((input, Node::MathExpression{name: op.to_string(), children: vec![args]}))}

pub fn l3(input: &str) -> IResult<&str, Node> {

  let (input, mut head) = l4(input)?;
  let (input, tail) = many0(l3_infix)(input)?;
  for n in tail {
    match n {
      Node::MathExpression{name, mut children} => {
        let mut new_children = vec![head.clone()];
        new_children.append(&mut children);
        head = Node::MathExpression{name, children: new_children};
      }
      _ => () 
    };
  }
  Ok((input, head))
}

pub fn l2_infix(input: &str) -> IResult<&str, Node> {

  let (input, _) = many0(tag(" "))(input)?;
  let (input, op) = alt((tag("*"),tag("/")))(input)?;
  let (input, _) = many0(tag(" "))(input)?;
  let (input, args) = l3(input)?;
  Ok((input, Node::MathExpression{name: op.to_string(), children: vec![args]}))

}

pub fn l2(input: &str) -> IResult<&str, Node> {
  
  let (input, mut head) = l3(input)?;
  let (input, tail) = many0(l2_infix)(input)?;
  for n in tail {
    match n {
      Node::MathExpression{name, mut children} => {
        let mut new_children = vec![head.clone()];
        new_children.append(&mut children);
        head = Node::MathExpression{name, children: new_children};
      }
      _ => () 
    };
  }
  Ok((input, head))

}

pub fn l1_infix(input: &str) -> IResult<&str, Node> {
  let (input, _) = many0(tag(" "))(input)?;
  let (input, op) = alt((tag("+"),tag("-")))(input)?;
  let (input, _) = many0(tag(" "))(input)?;
  let (input, args) = l2(input)?;
  Ok((input, Node::MathExpression{name: op.to_string(), children: vec![args]}))

}

pub fn l1(input: &str) -> IResult<&str, Node> {
  let (input, mut head) = l2(input)?;
  let (input, tail) = many0(l1_infix)(input)?;
  for n in tail {
    match n {
      Node::MathExpression{name, mut children} => {
        let mut new_children = vec![head.clone()];
        new_children.append(&mut children);
        head = Node::MathExpression{name, children: new_children};
      }
      _ => () 
    };
  }
  Ok((input, head))
}

pub fn math_expression(input: &str) -> IResult<&str, Node> {
  l1(input)
}

pub fn expression(input: &str) -> IResult<&str, Node> {

  let (input, expression) = alt((function_call, boolean, math_expression, string, number, identifier))(input)?;
  Ok((input, Node::Expression{children: vec![expression]}))   
}

pub fn statement(input: &str) -> IResult<&str, Node> {

  let (input, _) = multispace0(input)?;
  let (input, output) = alt((function_return, variable_define))(input)?;
  let (input, _) = multispace0(input)?;
  let (input, _) = tag(";")(input)?;
  Ok((input, Node::Statement{children: vec![output]}))   

}

pub fn function_return(input: &str) -> IResult<&str, Node> {

    let (input, _) = multispace0(input)?;
    let (input, _) = tag("return ")(input)?;
    let (input, _) = multispace0(input)?;
    let (input, output) = expression(input)?;
    Ok((input, Node::FunctionReturn {children: vec![output]}))

  }

pub fn variable_define(input: &str) -> IResult<&str, Node> {
  
  let (input, _) = multispace0(input)?;
  let (input, _) = tag("let ")(input)?;
  let (input, variable) = identifier(input)?;
  let (input, _) = many0(tag(" "))(input)?;
  let (input, _) = tag("=")(input)?;
  let (input, _) = many0(tag(" "))(input)?;
  let (input, expression) = expression(input)?;

  Ok((input, Node::VariableDefine{ children: vec![variable, expression]}))   
}

pub fn arguments(input: &str) -> IResult<&str, Node> {

  let (input, output) = expression(input)?;
  let (input, mut rest) = many0(other_arg)(input)?;
  let  mut args = vec![output];
  args.append(&mut rest);
  Ok((input, Node::FunctionArguments{ children: args}))

}

pub fn other_arg(input: &str) -> IResult<&str, Node> {

  let (input, _) = multispace0(input)?;
  let (input, _) = tag(",")(input)?;
  let (input, _) = many0(alt((tag(" "), tag("\n"), tag("\t"))))(input)?;
  let (input, expression) = expression(input)?;
  Ok  ((input, expression))

}

pub fn function_definition(input: &str) -> IResult<&str, Node> {
  
  let (input, _) = many0(alt((tag(" "), tag("\n"), tag("\t"))))(input)?;
  let (input, _) = tag("fn ")(input)?;
  let (input, identifier) = identifier(input)?;
  let mut output = vec![identifier];
  let (input, _) = tag("(")(input)?;
  let (input, mut args) = many0(arguments)(input)?;
  let (input, _) = tag(")")(input)?;
  let (input, _) = many0(alt((tag(" "), tag("\n"), tag("\t"))))(input)?;
  let (input, _) = tag("{")(input)?;
  let (input, _) = many0(alt((tag(" "), tag("\n"), tag("\t"))))(input)?;
  let (input, mut stats) = many1(statement)(input)?;
  let (input, _) = many0(alt((tag(" "), tag("\n"), tag("\t"))))(input)?;
  let (input, _) = tag("}")(input)?;
 
  output.append(&mut args);
  output.append(&mut stats);
  Ok((input, Node::FunctionDefine{children: output}))
}

pub fn comment(input: &str) -> IResult<&str, Node> {
  let (input, _) = tag("//")(input)?;
  let (input, comm) = many1(alt((alphanumeric1,tag(" "))))(input)?;
  Ok((input, Node::String{value: comm.join("")}))
}


pub fn program(input: &str) -> IResult<&str, Node> {
  let (input, result) = many1(alt((function_definition, statement, expression)))(input)?;  
  Ok((input, Node::Program{children: result}))       
} 