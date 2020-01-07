; --------------------------------
; Question 8
; --------------------------------
; fn main() {
;   let h = |i: i32| -> i32 { i + 1 };
;   let y = double_result(h);
; }
;
; fn double_result<F>(y: F) -> i32
;    where F: Fn(i32) -> i32 {
;    2 * y(1)
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
 ;(define (add_two y z) (+ y z))
;(define x (add_two 4 5)) 
  
(define (main h)(+ h 1))
(define (double_result c )(* c 2))
(define y (double_result(main 1)))
  ; ------------------
  ; Add code above
  (assert y 4))