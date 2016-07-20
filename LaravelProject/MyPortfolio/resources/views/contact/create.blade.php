@extends('template')

@section('content')
    <h1>New Contact</h1>
    <hr>
    <div class="mdl-grid">
        {!! Form::open(['url'=>'contact']) !!}
        <ul>
            <li>
                {!! Form::label('name', 'Name:') !!}
                {!! Form::text('name') !!}
            </li>
            <li>
                {!! Form::label('description', 'Description:') !!}
                {!! Form::text('description') !!}
            </li>
            <li>
                {!! Form::label('url', 'URL:') !!}
                {!! Form::text('url') !!}
            </li>
            <li>
                {!! Form::label('image', 'Image:') !!}
                {!! Form::text('image') !!}
            </li>
            <li>
                {!! Form::submit() !!}
            </li>
        </ul>
        {!! Form::close() !!}
    </div>
@stop