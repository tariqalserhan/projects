; --------------------------------
; Question 1
; --------------------------------
; fn main() {
;   let x = 10;
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define x 10)
  ; ------------------
  ; Add code above
  (assert x 10))