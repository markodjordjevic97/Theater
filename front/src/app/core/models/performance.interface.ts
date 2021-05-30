export interface Performace {
    id: number,
    title: string,
    duration: string,
    description: string,
    writer: {
        id: number,
        name: string,
        surname: string,
        birthDate: Date
    },
    type: {
        id: number,
        type: string
    }
}