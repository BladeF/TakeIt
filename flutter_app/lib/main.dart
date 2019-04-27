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
    if(_notes.length > 0) {
      return ListView.builder(
        itemBuilder: (context, index) {
          if(index < _notes.length) {
            return _buildRow(_notes[index]);
          }
        },
      );
    } else {
      return null;
    }
  } // _buildList

  Widget _buildRow(String note) {
    return Column(
      children: <Widget>[
        ListTile(
          title: Text(
            note,
            style: _biggerFont,
          ),
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

  void _takeNote() {
    setState(() {
      _notes.add('Sample Note');
    });
  }
}
