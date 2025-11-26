import os
import dspy
from dotenv import load_dotenv
load_dotenv()
ANTHROPIC_API_KEY = os.getenv("ANTHROPIC_API_KEY")
lm = dspy.LM("anthropic/claude-opus-4-5", api_key=ANTHROPIC_API_KEY)
dspy.configure(lm=lm)
math = dspy.ChainOfThought("question -> answer: float")
math(question="Two dice are tossed. What is the probability that the sum equals two?")
print(math)