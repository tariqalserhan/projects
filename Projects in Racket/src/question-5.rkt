; --------------------------------
; Question 5
; --------------------------------
; fn main() {
;   let s = "hello";
;   let x = if s.len() >= 5 && s.get(0..5).unwrap() == "hello" {
;     1 
;   } else {
;     2
;   };
;   println!("{:?}", x);
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define s [string #\h #\e #\l #\l #\o])
(define sub [substring "hello" 0 5])
(define z [bytes-length #"hello"]) 
(define x
(cond 
[(>= z 5) (string=? "hello" sub ) 1]
[else 2]))

  ; ------------------
  ; Add code above
  (assert x 1))