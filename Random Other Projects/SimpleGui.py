import tkinter as Simple

root = Simple.Tk()

canvas = Simple.Canvas(root, height=500, width=600)
canvas.pack()

frame = Simple.Frame(root, bg='gray')
frame.place(relx=0.1, rely=0.1, relheight=0.8, relwidth= 0.8)

button = Simple.Button(frame, text = "Test button", bg = 'blue', fg = 'red')
button.pack()

label = Simple.Label(frame, text="Label Example", bg="white")
label.pack()

entry = Simple.Entry(frame, bg='black', fg='white')
entry.pack()


root.mainloop()

