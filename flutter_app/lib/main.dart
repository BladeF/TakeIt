import 'package:flutter/material.dart';

void main() => runApp(TakeIt());

class TakeIt extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'TakeIt',
      home: NoteList(),
    );
  }
}

class NoteList extends StatefulWidget {
  @override
  State createState() => NoteListState();
}

class NoteListState extends State<NoteList> {
  final _notes = <String>[];
  final _biggerFont  = const TextStyle(fontSize: 18.0);

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text('TakeIt'),
      ),
      body: _buildList(),
      floatingActionButton: FloatingActionButton(
        onPressed: _takeNote,
        tooltip: 'Take a Note',
        child: Icon(Icons.add),
      ),
    );
  }
  
  Widget _buildList() {
    return ListView.builder(
      itemBuilder: (context, index) {
        if(index < _notes.length) {
          return _buildRow(_notes[index], index);
        }
      },
    );
  } // _buildList

  Widget _buildRow(String note, int index) {
    return Column(
      children: <Widget>[
        ListTile(
          title: Text(
            note,
            style: _biggerFont,
          ),
          onLongPress: (){
            _deleteNote(index);
          },
        ),
        Divider(
          color: Colors.grey,
        ),
      ],
    );

    /*return ListTile(
      title: Text(
        note,
        style: _biggerFont,
      ),
    );*/
  } // _buildRow

  void _saveNote(String note) {
    setState(() {
      _notes.add(note);
    });
  }

  void _deleteNote(int index){
    setState(() {
      _notes.removeAt(index);
    });
  }
  void _takeNote(){
    Navigator.of(context).push(
      MaterialPageRoute<void>(
        builder: (BuildContext context){
          return Scaffold(
            appBar: AppBar(
              title: Text("Create A New Note"),
            ),
            body: new TextField(
              autofocus: true,
              autocorrect: true,
              onSubmitted: (val){
                _saveNote(val);
                Navigator.pop(context);
              },
              decoration: new InputDecoration(
                hintText: 'Enter your new note',
                contentPadding: const EdgeInsets.all(16.0)
              ),
            ),
          );
        }
      )
    );
  }
}
