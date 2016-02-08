<?php
    /*$payload = null;
    
    try
    {
        $payload = json_decode($_REQUEST['payload']);
    }
    catch(Exception $e)
    {
        exit(0);
    }
    
    file_put_contents('logs/github.txt', print_r($payload, TRUE), FILE_APPEND);
    if ($payload->ref === 'refs/heads/master')
    {
    // path to your site deployment script
        exec('./get.sh');
    }
    */
    exec('./get.sh'); // Much simpler looool
    
?>