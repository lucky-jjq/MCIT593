README

Group project by JJ Qian and Xunjing Wu

The Parking Data Analyzer program reads data in csv, txt and json files, analyzes the parking data, and outputs the results into new txt files. The program follows the N-tier design architecture and has the following five components: 

- Data: builds the population object and the violation object. 
- Data Management: handles all the reading and writing to files. This also includes parsing data and filtering out non-PA and empty-zipcode data.  
- Processor: performs all the analysis on the data, including calculating total fines and fines per capita for each zipcode. 
- UI: prints fines per capita in each zipcode to the screen. 
- Main: calls different functions and puts the whole game together. 


The program expects one of the following two run configurations: 
csv parking.csv population.txt
OR 
json parking.json population.txt 


The program produces three outputs: 
fines.txt (individual parking violation's zipcode and fine amount)
total.txt (total fines per zip code)
prints fines per capita per zipcode (ascending order) to the screen

Note: 
Fines per capita is defined as total fines/ population in each individual zipcode. But some zipcodes lack population data. 
Therefore the last output (fines per capita) only prints out those zipcodes that have population data.

