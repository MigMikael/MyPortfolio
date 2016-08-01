<?php

namespace App\Http\Controllers;

use App\Http\Controllers\Controller;
use App\Fileentry;
use Request;

use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\File;
use Illuminate\Http\Response;
use App\Http\Requests;
use Log;


class FileEntryController extends Controller
{
    //
    public function index()
    {
        $entries = Fileentry::all();
        return view('fileentries.index', compact('entries'));
    }

    public function add()
    {
        $file = Request::file('filefield');
        $extension = $file->getClientOriginalExtension();
        Storage::disk('public')->put($file->getFilename().'.'.$extension,  File::get($file));
        $entry = new Fileentry();
        $entry->mime = $file->getClientMimeType();
        $entry->original_filename = $file->getClientOriginalName();
        $entry->filename = $file->getFilename().'.'.$extension;
        Log::info('#### Store File');

        $entry->save();

        return redirect('fileentry');
    }

    public function get($filename){
        $filename = str_replace('_','.',$filename);
        Log::info('#### Change Filename '.$filename);

        $entry = Fileentry::where('filename', '=', $filename)->firstOrFail();
        $file = Storage::disk('public')->get($entry->filename);

        return (new Response($file, 200))->header('Content-Type', $entry->mime);
    }
}
