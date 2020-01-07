; --------------------------------
; Question 11
; --------------------------------
; fn main() {
;   let x = vec![1, 2, 3];
;   let y: Vec<i32> = x.iter().map(|x| x * 2).collect();
;   let z = y[1];
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define x (vector 1 2 3 ))
(define (multiply_two z)(* z 2))
(define y (vector-map! multiply_two x ))
(define z (vector-ref y 1))
  ; ------------------
  ; Add code above
  (assert z 4))