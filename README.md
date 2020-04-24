# Two Step Machine Learning Microcirculation Analyzer #

Algorithm to analyze perfusion (flow) of capiliary blood vessels using machine learning

## Pre-requisites ##
- Make sure you have the following addons:
	- Matlab runtime 2020a
    - Computer vision add-on
    - Image processing add-on
- Make sure you have python 3.5-3.7 installed
    - To check python version:
    - MAC: Open spotlight search, type terminal, open terminal window
    - WINDOWS: open start menue, search for cmd, and open cmd terminal
    - in terminal write: python3 --version
    - Proceed if in the terminal a version number like 3.7.X shows up
    - Otherwise install python from here. https://www.python.org/downloads/release/python-377/
## Running ##
- Download or clone repository
-
- Now run the VesselDetector.exe

To use APPLICATION:
- Press browse button, then select target Experiment video file (.avi)
- When the video appears, you may press play button to see it play, then pause
- After select settings for analysis:
    - Number of crosssections: 3 to 10 cross-sections
    - Flowing threshold: increase to be detect fewer borderline vessels
    - Min vessel length: set minmum length in pixels of vessel to be accepted
        - (Probably should not change this too much)
    - then press analyze results
- Be patient analysis can take between 2-4 minutes depending on computer speed
- See results in new window :()
    - Results are modifiable:
        - To remove a point detected by the computer, just click on it
        - To add a point, just click on the image where you would like to add it
    - When ready press save results to save results
    - Enter prefix name of files to save:
    - Program will save 3 files with entered prefix
        - prefix_initial_points_found.txt
        - prefix_final_points_found.txt
        - prefix_SAD_results.bmp
    - for intermediaray results, look through working directory
