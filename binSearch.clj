;; binary search an array, return index if found and nil otherwise
;; search for all numbers in a simple integer sequence as a test
;; and print results.  Pretty ugly, but one of my first clojure programs
;; so bear with me.
;; 1-27-2016

(defn binSearch
  ([x dat] (binSearch x dat 0))
  ([x dat klo]
   (if (< x (nth dat 0)) nil
       (if (> x (nth dat (- (count dat) 1))) nil
           (do
             (def kmid (quot (count dat) 2))
             (def xmid (nth dat kmid))
             (if (> x xmid) (binSearch x (subvec dat (+ kmid 1)) (+ klo kmid 1))
                 (if (< x xmid) (binSearch x (subvec dat 0 kmid) klo ) (+ klo kmid) )))))))


; sample output

(def myData (vec (range 100)))
(doseq [x (shuffle (range 100))]
  (println x (nth myData (binSearch x myData))))
