; --------------------------------
; Question 10
; --------------------------------
; fn main() {
;   let x = vec![1 2 3];
;   let y = x.len();
;   let z = x[2] + y;
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define x (vector 1 2 3 ))
(define y (vector-length x))
(define z (+ y (vector-ref x 2)))
  ; ------------------
  ; Add code above
  (assert z 6))