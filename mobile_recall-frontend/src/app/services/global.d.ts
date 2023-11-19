export {}; // Makes the file a 'module'

declare global {

  type Creator = {
    identifier: string;
    username: string;
  }

  type CardGroup = {
    identifier: string;
    groupName: string;
    creator: Creator;
  }

  type Card = {
    identifier: string;
    question: string;
    expectedAnswer: string;
    creationDate: Date;
    successRate: number;
    cardGroup: CardGroup;
  }

}
