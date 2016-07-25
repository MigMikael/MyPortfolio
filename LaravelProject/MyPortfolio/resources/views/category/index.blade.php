@extends('template')

@section('content')
    @foreach($categories as $category)
        <div class="mdl-cell mdl-cell--12-col mdl-card mdl-card mdl-shadow--4dp">
            <div class="mdl-card__title">
                <h2 class="mdl-card__title-text">{{ $category->name }}</h2>
            </div>
            <div class="mdl-card__supporting-text">
                {{ $category->description }}
            </div>
            <div class="mdl-card__actions mdl-card--border">
                <a class="mdl-button mdl-button--colored mdl-js-button mdl-js-ripple-effect mdl-button--accent" href="{{--{{ url('post/'.$category->id) }}--}}">
                    Show
                </a>
            </div>
        </div>
    @endforeach
    </ul>
@stop