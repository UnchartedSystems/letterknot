# Interaction Design

## Select & Edit individual Letters vs Words?
The challenge is that rows should be selected and edited as words, but displayed as individual letters. 

https://github.com/dannyradden/single-character-input-boxes
https://developer.mozilla.org/en-US/docs/Web/HTML/Global_attributes/tabindex
https://stackoverflow.com/questions/5192859/how-to-ignore-html-element-from-tabindex

### Chained Single Char inputs
There's gonna be a lot of finangling input states:
 - Each word will be multiple single char input forms
 - Tab will skip to first box of next incomplete or broken word (wrapping)
 - Arrow keys will NOT navigate single input forms
 - Selecting any input box in a sequence will you bring you to the first unfinished box
 - Clicking on a finished word and typing will delete whole previous word, write new typed chars

### Another option
Just make input a single invisible form triggered by a button, and then have elements show corresponding letters! This solves a ton of problems:
 - Styling elements is easy compared to forms!
 - Can process input as a single word and slice single letters into elements

### What about preset letters?

## Thinking about Game Loop
### One hidden form per row
Type word, hit enter to confirm (dotted borders for unconfirmed)
Where does focus go next?
 - Order rows from current position, cycling forward. (ie: if 3: 4,5,1,2)
   - Check all rows in order for unconfirmed/unfinished, focus on first one
   - ELSE THEN: check all rows for rule violations, focus on first one
   - ELSE THEN: You win!
