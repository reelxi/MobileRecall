// .d.ts File = Declaration File => putting things into global scope | not modules! not for types!
// .ts File = Normal Module

export type User = {
  identifier: string;
  username: string;
  password: string;
}

export type Card = {
  identifier: string;
  question: string;
  expectedAnswer: string;
  creationDate: Date;
  successRate: number;
  cardGroupId: string;
}

export type CardGroup = {
  identifier: string;
  groupName: string;
  creatorId: string;
}
