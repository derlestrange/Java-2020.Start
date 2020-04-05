public class Loader {
    public static void main(String[] args) {
        String text = "What is Procrastination?\n" +
                "Human beings have been procrastinating for centuries. The problem is so timeless, in fact, that ancient Greek philosophers like Socrates and Aristotle developed a word to describe this type of behavior: Akrasia.\n" +
                "\n" +
                "Akrasia is the state of acting against your better judgment. It is when you do one thing even though you know you should do something else. Loosely translated, you could say that akrasia is procrastination or a lack of self-control.\n" +
                "\n" +
                "Here's a modern definition:\n" +
                "\n" +
                "Procrastination is the act of delaying or postponing a task or set of tasks. So, whether you refer to it as procrastination or akrasia or something else, it is the force that prevents you from following through on what you set out to do.\n" +
                "\n" +
                "\n" +
                "Why Do We Procrastinate?\n" +
                "Ok, definitions are great and all, but why do we procrastinate? What is going on in the brain that causes us to avoid the things we know we should be doing?\n" +
                "\n" +
                "This is a good time to bring some science into our discussion. Behavioral psychology research has revealed a phenomenon called “time inconsistency,” which helps explain why procrastination seems to pull us in despite our good intentions. Time inconsistency refers to the tendency of the human brain to value immediate rewards more highly than future rewards.";

        // обычное разделение, знаки препинания остаются
        // String[] textWithReg = text.split("\\s");

        // убираем знаки препинания, разбиваем текст по словам
        String[] textWithReg = text.replaceAll("\\p{P}", "").split("\\s");
        for (String textWithRegEx : textWithReg){
            System.out.println(textWithRegEx);
        }
    }
}
