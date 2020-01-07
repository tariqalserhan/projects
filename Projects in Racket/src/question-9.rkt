; --------------------------------
; Question 9
; --------------------------------
;
; struct point {
;   x: u32,
;   y: u32,
; }
;
; fn main() {
;  let p = Point {x: 10, y: 20};
;  let x = p.x;
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(struct point (x y))
(define p (point 10 20))
(define x (point-x p))
  ; ------------------
  ; Add code above
  (assert x 10))