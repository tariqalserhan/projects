#lang racket

(provide assert)

(define (assert a b)
  (if (= a b)
    (exit) 
    (raise 0)))