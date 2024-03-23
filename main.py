import speech_recognition as sr
def listen_for_command():
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        audio = recognizer.listen(source)
    
    try:
        # Use Google Speech Recognition to transcribe the audio
        text = recognizer.recognize_google(audio)
        print("You said:", text)
        process_command(text)
    except sr.UnknownValueError:
        print("Sorry, could not understand audio.")

def process_command(text):
    # Define keywords or sentences to match
    if "turn on the lights" in text:
        print("Turning on the lights...")
        # Perform action to turn on lights
    elif "play music" in text:
        print("Playing music...")
        # Perform action to play music
    else:
        print("Command not recognized.")

# Continuously listen for commands
while True:
    recognizer = sr.Recognizer()
    with sr.Microphone() as source:
        print("Listening...")
        print(recognizer.recognize_whisper(recognizer.listen(source)))