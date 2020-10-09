import React from "react";
import Button from '@material-ui/core/Button';
import { Add } from '@material-ui/icons';

export function Admin() {
    return (
        <div>
            <Button
                variant="contained"
                color="primary"
                size="large"
                startIcon={<Add />}
            >
                Create a new relay
            </Button>
        </div>
    )
}


interface Verse {
    book: string,
    chapter: number,
    verse: number
}

interface Relays {
    id: string,
    name: string,
    active: boolean,
    startVerse: Verse,
    endVerse: Verse
}


function RelayList(props: Relays) {
    return (<></>)
}