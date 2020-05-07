Write a function that takes in an array of integers and returns a boolean representing whether the array is monotonic.

An array is said to be monotonic if its elements, from left to right, are entirely non-increasing or entirely non-decreasing.

Sample Input
array = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
Sample Output
true




Monotonic Array
   
   <p>
         Write a function that takes in an array of integers and returns a boolean
         representing whether the array is monotonic.
      </p>
      <p>
         An array is said to be monotonic if its elements, from left to right, are
         entirely non-increasing or entirely non-decreasing.
      </p>
      <h3>Sample Input</h3>
      <pre><span class="CodeEditor-promptParameter">array</span> = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
   </pre>
      <h3>Sample Output</h3>
      <pre>true
   </pre>
   </div>
   <div class="aHEBHnsEqYwHLYwlr4lZg">
      <h3 class="_17HgLmZQsO1vweWcAMvE31">Hints</h3>
      <div class="_1CnYFH5mCs_em2ULQwl3b6">
         <div class="
            _1hH8ZISLvXsf13iPLSlhb
            JTSqCjQ07wP6vIz7vfFcX
            " tabindex="0">
            <div class="
               _2HaDIwDUItYJqs3V-vAas3
               _2KkjqymaoVsNU_QIKbAnp7">
               <span>Hint 1</span>
               <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" class="_3W4BNWAoPumm6HQqjDeZxe ">
                  <path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path>
               </svg>
            </div>
            <div class="_3qcscihxUSlBT3ywIMap5K" style="transition-duration: 0.6s; height: 0px;">
               <p class="_3nVuYIxRwVvifJRcbJqRO7">You can solve this question by iterating through the input array from left to right once.</p>
            </div>
         </div>
      </div>
      <div class="_1CnYFH5mCs_em2ULQwl3b6">
         <div class="
            _1hH8ZISLvXsf13iPLSlhb
            JTSqCjQ07wP6vIz7vfFcX
            " tabindex="0">
            <div class="
               _2HaDIwDUItYJqs3V-vAas3
               _2KkjqymaoVsNU_QIKbAnp7">
               <span>Hint 2</span>
               <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" class="_3W4BNWAoPumm6HQqjDeZxe ">
                  <path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path>
               </svg>
            </div>
            <div class="_3qcscihxUSlBT3ywIMap5K">
               <p class="_3nVuYIxRwVvifJRcbJqRO7">Try iterating through the input array from left to right, in search of two adjacent integers that can indicate whether the array is trending upward or downward. Once you've found the tentative trend of the array, at each element thereafter, compare the element to the previous one; if this comparison breaks the previously identified trend, the array isn't monotonic.</p>
            </div>
         </div>
      </div>
      <div class="_1CnYFH5mCs_em2ULQwl3b6">
         <div class="
            _1hH8ZISLvXsf13iPLSlhb
            JTSqCjQ07wP6vIz7vfFcX
            " tabindex="0">
            <div class="
               _2HaDIwDUItYJqs3V-vAas3
               _2KkjqymaoVsNU_QIKbAnp7">
               <span>Hint 3</span>
               <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" class="_3W4BNWAoPumm6HQqjDeZxe ">
                  <path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path>
               </svg>
            </div>
            <div class="_3qcscihxUSlBT3ywIMap5K">
               <p class="_3nVuYIxRwVvifJRcbJqRO7">Alternatively, you can start by assuming that the array is both entirely non-decreasing and entirely non-increasing. As you iterate through each element, perform a check to see if you can invalidate one or both of your assumptions.</p>
            </div>
         </div>
      </div>
      <div class="_1CnYFH5mCs_em2ULQwl3b6">
         <div class="
            _1hH8ZISLvXsf13iPLSlhb
            JTSqCjQ07wP6vIz7vfFcX
            " tabindex="0">
            <div class="
          team     _2HaDIwDUItYJqs3V-vAas3
               _2KkjqymaoVsNU_QIKbAnp7">
               <span>Optimal Space &amp; Time Complexity</span>
               <svg xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 292.362 292.362" class="_3W4BNWAoPumm6HQqjDeZxe ">
                  <path d="M286.935 69.377c-3.614-3.617-7.898-5.424-12.848-5.424H18.274c-4.952 0-9.233 1.807-12.85 5.424C1.807 72.998 0 77.279 0 82.228c0 4.948 1.807 9.229 5.424 12.847l127.907 127.907c3.621 3.617 7.902 5.428 12.85 5.428s9.233-1.811 12.847-5.428L286.935 95.074c3.613-3.617 5.427-7.898 5.427-12.847 0-4.948-1.814-9.229-5.427-12.85z"></path>
               </svg>
            </div>
            <div class="_3qcscihxUSlBT3ywIMap5K">
               <p class="_3nVuYIxRwVvifJRcbJqRO7">O(n) time | O(1) space - where n is the length of the array</p>
            </div>
         </div>
      </div>
   </div>
   


