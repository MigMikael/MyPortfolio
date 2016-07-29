@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--8-col mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Edit Blog</h2>
        </div>
        <div class="mdl-card__supporting-text">
            {!! Form::model($post, ['method' => 'PATCH','url'=>'post/'.$post->id]) !!}
                @include('posts._form', ['submitButtonText' => 'finish'])
            {!! Form::close() !!}
        </div>
    </div>

    <div class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--4dp">
        <p>image</p>
    </div>
@stop