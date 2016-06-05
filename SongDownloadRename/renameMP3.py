import eyed3
import os


# Get all the files present in the current directory

all_files = os.listdir(".")
for filename in all_files:
	if filename.find(".mp3") != -1:
		audiofile = eyed3.load(filename)
		if os.path.exists(audiofile.tag.album):
			os.rename(filename,  audiofile.tag.album + "/" + audiofile.tag.title + ".mp3")
		else:
			os.mkdir(audiofile.tag.album)
			os.rename(filename,  audiofile.tag.album + "/" + audiofile.tag.title + ".mp3")



