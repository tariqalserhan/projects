; --------------------------------
; Question 2
; --------------------------------
; fn main() {
;    let x = 10;
;    let y = if x == 10 {
;        1
;    } else {
;        2
;    };
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define x 10)
  (define y 
      (cond
          [(= x 10) 1]
          [else 2]
      ))
  ; ------------------
  ; Add code above
  (assert y 1))