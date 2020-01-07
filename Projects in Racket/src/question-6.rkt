; --------------------------------
; Question 6
; --------------------------------
; fn main() {
;   let s = String::from("hello0123!");
;   let mut z = 0;
;   for c in s.chars() { 
;     match c {
;       'a'...'z' => z += 1,
;       '0'...'9' => z += 2,
;       _ => z += 3,
;     };
;   }
; }

#lang racket

(module test racket 
  (require "assert.rkt")
  ; Add code below
  ; ------------------
(define s (string #\h #\e #\l #\l #\o #\0 #\1 #\2 #\3 #\!) )
  (define z 0)
  (for ([char (string-length s)])
    (define i (string-ref s char))
    (cond
      [(char>=? i #\a)(char<=? i #\z) (set! z (+ z 1))]
      [(char>=? i #\0)(char<=? i #\9) (set! z (+ z 2))]
      [else (set! z (+ z 3))]
    )
  )
  ; ------------------
  ; Add code above
  (assert z 16))