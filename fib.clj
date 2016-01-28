; simple program to calculate and print fibonacci numbers
; my first clojure program written without reference
;

(defn fib
  ([n] (if (== n 0) 0 (if (> n 0) (fib (- n 1) [1,1]) nil)) )
  ([n,fib_] (if (== n 0) (nth fib_ 0)
                (if (> n 0) (fib (- n 1) [(nth fib_ 1), (apply + fib_)]) nil))))

(doseq [c (range -1 20)] (println (str c) (fib c)))

