from subprocess import call

for i in range (15583, 15701):
	call(["wget", "http://101songs.com/fileDownload/Songs/128/" + str(i) + ".mp3"]) 
