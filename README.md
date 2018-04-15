# camera

Description of problem: 
Given the description of the objects such that a vehicle called GCV, is traveling along the x-axis. You are given the distance of the GCV’s path from a "Great Occluder" in meters, which means that a wall lies on the line y = d, where d is the distance from the path in meters. You are also given the starting and ending point of a Glass Partition. Using the combined information the glass partition lies on the line segment (b, d) and (e, d), where the partition begins at b meters from the y-axis and ends at e meters from the y-axis. You will be given a list of objects that need their picture taken. No object will be on the Great Occluder. Additionally you can assume that no object will block the vision of any other object; all objects can be consider points for the sake of width. Lastly the wall’s thickness will be negligible.

Inputs:
The first line of input begins with two positive integers, n and d (n < 100,000; d < 100,000), which represents the number of objects and the distance (in meters) in the positive y direction the Great Occluder is from the path of the GCV. The next line contains two positive integers, b and e (b < e < 100,000), which represent the beginning and ending index of the Glass Partition in meters from the y-axis. The remaining n lines contain two positive integers, xi and yi (xi, yi < 100,000), where the i-th pair (xi, yi) represent the Cartesian coordinate of the i-th object in meters from the origin.

Ex. inputs (numbered):

1.) 
2 2
3 5 
2 3 
6 3
  
2.) 
2 1 
3 5 
2 2 
6 2

 
3.)
1 4 
1 10 
1 1
1
  
 
4.)
4 1
9 10 
1 2 
20 2 
9 100 
9 2

Ex. ouputs (numbered):

1.) 2
2.) 1
3.) 1
4.) 3