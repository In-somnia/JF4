package task6;


/** <p>Notepad is a simple tool for creating, editing, removing, storing and viewing notes. </p> */
class Notepad {
    static Note[] notes = new Note[1];
    /** <p> Method addNote allows to create a new note and save it in the notepad. It creates an empty
     * slot in the array every time a user wants to add a new note.
     * @param str is the text a user's note. </p>*/
    static void addNote(String str)
    {
        if (notes.length == 1)
        {
            if(notes[0] == null)
            {
                notes[0] = new Note(str);
            }
            else
            {
                Note[] tmp = new Note[notes.length + 1];
                System.arraycopy(notes, 0, tmp, 0, notes.length);
                tmp[tmp.length - 1] = new Note(str);
                notes = tmp;
            }
        }
        else
        {
            Note[] tmp = new Note[notes.length + 1];
            System.arraycopy(notes, 0, tmp, 0, notes.length);
            tmp[tmp.length - 1] = new Note(str);
            notes = tmp;
        }
        System.out.println("Запись создана.");
    }
    /** Method editNote allows to change any note in the notepad by its number.
     * @param editNum is a sequence number of the note
     * @param editStr is a edited message a user wants to save instead of the previous one
     * Enumeration starts with number 1 for a user. */
    static void editNote(int editNum, String editStr)
    {
        notes[editNum - 1] = new Note(editStr);
        System.out.println("Запись изменена.");
    }
    /** Method showAllNotes allows to see all the notes saved in the array.
     * The notes are enumerated starting with number 1. */
    static void showAllNotes()
    {
        System.out.println("Вы внесли следующие записи:");
        for (int i = 0; i < notes.length; i++)
        {
            System.out.println("Запись " + (1 + i) + ": " + notes[i].text);
        }
    }
    /** Method removeNote allows to remove a note from the array by its number.
     * @param removeNum is the sequence number of the note to be deleted. */
    static void removeNote(Note[] array, int removeNum)
    {
        Note[] array1 = new Note[array.length - 1];
        System.arraycopy(array, 0, array1, 0, removeNum - 1);
        System.arraycopy(array, removeNum, array1, removeNum - 1, array.length - removeNum);
        notes = array1;
        System.out.println("Запись " + removeNum + " удалена.");
    }
}
