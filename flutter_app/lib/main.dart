import 'package:flutter/material.dart';

void main() => runApp(TakeIt());

class TakeIt extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'TakeIt',
      home: Scaffold(
        appBar: AppBar(
          title: Text('TakeIt'),
        ),
        body: Center(
          child: Text('Write your first note'),
        ),
      ),
    );
  }
}

/*
class NoteList extends StatefulWidget {

  @override
  State createState() => NoteListState()
}

class NoteListState extends State<String> {

}*/
