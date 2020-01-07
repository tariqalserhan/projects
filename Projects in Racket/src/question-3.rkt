; --------------------------------
; Question 3
; --------------------------------
; fn main() {
;    let x = 20;
;    let y = if x == 10 {
;      1
;    } else if x > 10 {
;      2
;    } else {
;      3
;    };
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define x 20)
(define y
(cond
[(= x 10) 1]
[(> x 10) 2] 
[else 3] ))
  ; ------------------
  ; Add code above
  (assert y 2))