@extends('template')

@section('content')
    <div class="mdl-cell mdl-cell--8-col mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Create Blog</h2>
        </div>
        <div class="mdl-card__supporting-text">
            {!! Form::open(['url'=>'post']) !!}
                @include('posts._form', ['submitButtonText' => 'Add'])
            {!! Form::close() !!}
        </div>
    </div>

    {{--@include('fileentries._show')--}}

    <div class="mdl-cell mdl-cell--4-col mdl-card mdl-shadow--4dp">
        <div class="mdl-card__title">
            <h2 class="mdl-card__title-text">Images</h2>
        </div>

        <ul class="mdl-list">
            @foreach($images as $image)
            <li class="mdl-list__item">
                <span class="mdl-list__item-primary-content">
                    <img src="{{route('getentry', str_replace('.','_',$image->filename))}}" class="image-list-icon" alt="">
                    <button onclick="addText()" class="mdl-button mdl-js-button mdl-button--primary">
                        add
                    </button>

                </span>
            </li>
            <hr>
            @endforeach
        </ul>
    </div>
@stop