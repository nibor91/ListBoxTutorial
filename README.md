Handout

list = new JList(data); //data has type Object[]

 list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);<br>
 list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
 list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
list.setLayoutOrientation(JList.VERTICAL_WRAP);
list.setLayoutOrientation(JList.VERTICAL);

list.setVisibleRowCount(jList.getComponentCount() - 1);  // Durch die Anzahl der möglichen Zeilen lassen sich die Spalten beeinflussen
