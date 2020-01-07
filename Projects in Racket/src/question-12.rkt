; --------------------------------
; Question 12
; --------------------------------
; fn main() {
;   let x = vec![1, 2, 3];
;   let y: i32 = x.iter().fold(0, |acc, i| acc + i );
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define x (vector 1 2 3))
(define y (for/sum ([i x]) i))
  ; ------------------
  ; Add code above
  (assert y 6))