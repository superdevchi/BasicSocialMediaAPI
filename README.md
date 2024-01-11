# SocialMediaAPI with Spring Boot
BASIC SOCIAL MEDIAL API TO CREATE MULTIPLE USER, CREATE A POST, COMMENT ON POST, LIKE POST.

In this project i will list the endpoint to hit when you run program

# CREATE USER
UserName,FirstName,LastName,ImageFile(Image File up to 10MB).
Image upload is done with amazon aws, if ImageFile is NULL, imageFileUrl = ""; 


POST - localhost:2001/User/create 
`Form-data`
KEY: 
UserName:Text
FirstName:Text
LastName:Text
ImageFile:File


# LIST OF USERS
GET - localhost:2001/User/List

# CREATE POST
get USERID from CREATE USER response
POST - localhost:2001/Post/USERID/create
`Form-data`
KEY: 
PostContent:Text
ImageFile:File

# DELETE POST
get POSTID from CREATE POST response
DELETE - localhost:2001/Post/POSTID

# GET ALL POST BY A USER
POST - localhost:2001/Post/USERID


# CREATE COMMENT ON POST(COMMENT CAN BE FROM ANOTHER USER ID THEY ARE MORE THAN ONE USER CREATED)
get USERID,POSTID 
POST - localhost:2001/Comment/USERID/POSTID/create
`Form-data`
KEY: 
Comment:Text

# GET ALL COMMENT ON A PARTICULAR POST
get POSTID
GET - localhost:2001/Post/POSTID

# LIKE A POST
GET USERID,POSTID 
POST - localhost:2001/Likes/USERID/POSTID/like

# GET ALL LIKES ON A POST
GET - localhost:2001/Likes/POSTID

# FOLLOW A USER
get both USERID
POST - localhost:2001/Follow/USERID/FOLLOWERUSERID

# GET ALL FOLLOWER OF USER
GET - localhost:2001/Follow/USERID

