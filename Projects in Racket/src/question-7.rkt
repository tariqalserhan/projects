; --------------------------------
; Question 7
; --------------------------------
; fn add_two(x: u16, y: u16) -> u16 {
;   x + y 
; }
; 
; fn main() {
;   let x = add_two(4,5);
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define (add_two y z) (+ y z))
(define x (add_two 4 5))
  ; ------------------
  ; Add code above
  (assert x 9))