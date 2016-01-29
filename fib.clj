;; simple programs to calculate and print fibonacci numbers

;; using iterate
;; 1-28-2016
(defn fib4 [n]
  (if (< n 0) nil 
      (let [ nextOne (fn [[a,b]] [b,(+ a b)]) ]
        (nth (nth (iterate nextOne [0,1]) n) 0))))

;; using recursion. slightly cleaner than fib1 by using better
;; parameter handling
;; 1-28-2016      
(defn fib3 
  ([n] (if (< n 0) nil (fib3 n [0,1])))
  ([n [a b]] (if (zero? n) a
                 (fib3 (dec n) [b, (+ a b)]))))

;; using loop/recur
;; 1-28-2016

(defn fib2 [n]
  (if (< n 0) nil
      (loop [fib_ [0,1] i n]
        (if (zero? i)
          (nth fib_ 0)
          (recur [(nth fib_ 1) (apply + fib_)] (dec i))))))


;; using recursion. my first clojure program eva'.
;; 1-27-2016

(defn fib1
  ([n] (if (== n 0) 0 (if (> n 0) (fib1 (- n 1) [1,1]) nil)) )
  ([n,fib_] (if (== n 0) (nth fib_ 0)
                (if (> n 0) (fib1 (- n 1) [(nth fib_ 1), (apply + fib_)]) nil))))


;; sample output

(doseq [c (range -1 20)] (println (str c) (fib1 c)))
(doseq [c (range -1 20)] (println (str c) (fib2 c)))
(doseq [c (range -1 20)] (println (str c) (fib3 c)))
(doseq [c (range -1 20)] (println (str c) (fib4 c)))
