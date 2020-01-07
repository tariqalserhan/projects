# Lehigh University CSE262 - Programming Languages - Homework 4

This assignment asks you to familiarize yourself with the syntax and semantics of the Racket programming language. There are 12 problems in total located in the `/src` directory.

Each question presents Rust code at the top (commented out) that you are to translate into equivalent Racket code. The `(assert)` call at the bottom of each question tests a variable against the expected value. A correct program will pass this test. A program that produces an incorrect result will fail.

## Running

To run a question, run the following command in the homework-4 root directory.

```bash
> raco test -s test src/question-#.rkt
```

Where `#` is the number of the question you want to run. Raco is a tool much like cargo that allows you to build and test Racket programs. It is installed with the Racket distribution, but you may need to add your Racket directory to your PATH ([Windows instructions](https://www.computerhope.com/issues/ch000549.htm) [Mac instructions](https://www.architectryan.com/2012/10/02/add-to-the-path-on-mac-os-x-mountain-lion/#.Uydjga1dXDg)) in order to use it from the command line. Instructions for using raco can be found [here](https://docs.racket-lang.org/raco/test.html).

## Instructions

1. Fork the relevant repository into your own namespace. [Instructions](https://docs.gitlab.com/ee/workflow/forking_workflow.html#creating-a-fork)
2. Set your forked repository visibility to private. [Instructions](https://docs.gitlab.com/ee/public_access/public_access.html#how-to-change-project-visibility)
3. Add user "LehighCSE262" as a member to the project with "maintainer" access-level. [Instructions](https://docs.gitlab.com/ee/user/project/members/#add-a-user). 
4. Clone your newly forked repository. [Instructions](https://docs.gitlab.com/ee/gitlab-basics/start-using-git.html#clone-a-repository) 
5. Write code sufficient to make the tests pass. As you are writing code you should commit patches along the way. *i.e.* don't just submit all your code in one big commit when you're all done. Commit your progress as you work.
6. When you've passed all tests and you're ready to submit your work, indicate this on the corresponding assignment on course site. 