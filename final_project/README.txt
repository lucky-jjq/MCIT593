README

The program follows the N-tier design architecture and has the following five components: 
- Data: this builds the population object and the violation object. 
- Data Management: this handles all the reading and writing to files. This also includes parsing data and filtering out non-PA and empty-zipcode data.  
- Processor: this performs all the analysis on the data, including calculating total fines and fines per capita for each zipcode. 
- UI: this prints fines per capita in each zipcode to the screen. 
- Main: this calls different functions and puts the whole game together. 


The program expects one of the following two run configurations: 
csv parking.csv population.txt
OR 
json parking.json population.txt 


The program produces three outputs: 
fines.txt (individual parking violation's zipcode and fine amount)
total.txt (total fines per zip code)
prints fines per capita per zipcode to the screen

END