; binary search an array, return index if found and nil otherwise
; search for all numbers in a simple integer sequence as a test
; and print results

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


(def myData (vec (range 100)))
(doseq [x myData] (do
                    (def i (binSearch x myData))
                    (println x (nth myData i))))
