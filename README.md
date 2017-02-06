<h1>Handout/Spicker</h1>

<b>Benötigte Objekte</b><br><br>
list = new JList(data); //data has type Object[]<br>
oder<br>
list = new JList(listModel);<br>
listModel = new DefaultListModel\<Auto>();<br>
<br>
<b>Selection-Modes</b><br>
 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);<br>
 list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);<br>
 list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);<br>
<br>
<b>Orientierung</b><br>
list.setLayoutOrientation(JList.HORIZONTAL_WRAP);<br>
list.setLayoutOrientation(JList.VERTICAL_WRAP);<br>
list.setLayoutOrientation(JList.VERTICAL);<br>
<br>
<b>Anzeige modifizieren</b><br>
list.setVisibleRowCount(list.getComponentCount() - 1);  // Durch die Anzahl der möglichen Zeilen lassen sich die Spalten beeinflussen.<br> <i>Achtung: wenn ein Model verwendet wurde, muss dessen Größe verwendet werden</i><br>
<br>
<b>Eigener Listenertyp</b><br>
list.addListSelectionListener(new ListSelectionListener() {...});<br>
<br>
<br>
<b>Hinzufügen und entfernen</b><br>
listModel.remove(list.getSelectedIndex());<br>
listModel.addElement(ELEMENT);<br>
listModel.add(position,ELEMENT);<br>
<b>Auswahl auslesen</b><br>
list.getSelectedIndex() ==> gibt niedrigsten Index der ausgewählt wurde oder -1 <br>
list.getSelectedIndices() ==> gibt jeden ausgewählten Index in einem array zurück<br>
