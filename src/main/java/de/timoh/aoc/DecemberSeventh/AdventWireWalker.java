package de.timoh.aoc.DecemberSeventh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Timo Hanisch / timohanisch@gmail.com
 * @since 07.12.2015
 */
public class AdventWireWalker extends AdventWireBaseListener {

    private Map<String, Character> identifierMap = new HashMap<>();

    private List<AdventWireParser.AssignContext> assignCache = new ArrayList<>();
    private List<AdventWireParser.AndContext> andCache = new ArrayList<>();
    private List<AdventWireParser.OrContext> orCache = new ArrayList<>();
    private List<AdventWireParser.LshiftContext> lshiftCache = new ArrayList<>();
    private List<AdventWireParser.RshiftContext> rshiftCache = new ArrayList<>();
    private List<AdventWireParser.NotContext> notCache = new ArrayList<>();

    public int getValue(String identifier) {
        while(checkCaches()) {

        }
        return identifierMap.get(identifier);
    }

    @Override
    public void enterAssign(AdventWireParser.AssignContext ctx) {
        checkCaches();
        String id = ctx.IDENTIFIER().getText();
        if (ctx.operand().IDENTIFIER() != null) {
            if (!identifierMap.containsKey(ctx.operand().IDENTIFIER().getText())) {
                assignCache.add(ctx);
            } else {
                identifierMap.put(id, identifierMap.get(ctx.operand().IDENTIFIER().getText()));
            }
        } else if (!identifierMap.containsKey(id)) {
            identifierMap.put(id, (char) Integer.parseInt(ctx.operand().INTEGER().getText()));
        }
    }

    private void assign(AdventWireParser.AssignContext ctx) throws NullPointerException {
        String id = ctx.IDENTIFIER().getText();
        if (ctx.operand().IDENTIFIER() != null) {
            if (!identifierMap.containsKey(ctx.operand().IDENTIFIER().getText())) {
                throw new NullPointerException();
            } else {
                identifierMap.put(id, identifierMap.get(ctx.operand().IDENTIFIER().getText()));
            }
        } else if (!identifierMap.containsKey(id)) {
            identifierMap.put(id, (char) Integer.parseInt(ctx.operand().INTEGER().getText()));
        }
    }

    @Override
    public void enterAnd(AdventWireParser.AndContext ctx) {
        checkCaches();
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = 0, val2 = 0;
        try {
            val1 = getValue(op1);
            val2 = getValue(op2);
            identifierMap.put(id, (char) (val1 & val2));
        } catch (NullPointerException npe) {
            andCache.add(ctx);
        }
    }

    private void and(AdventWireParser.AndContext ctx) throws NullPointerException {
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = getValue(op1);
        char val2 = getValue(op2);
        identifierMap.put(id, (char) (val1 & val2));
    }

    @Override
    public void enterOr(AdventWireParser.OrContext ctx) {
        checkCaches();
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = 0, val2 = 0;
        try {
            val1 = getValue(op1);
            val2 = getValue(op2);
            identifierMap.put(id, (char) (val1 | val2));
        } catch (NullPointerException npe) {
            orCache.add(ctx);
        }
    }

    private void or(AdventWireParser.OrContext ctx) throws NullPointerException {
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = getValue(op1);
        char val2 = getValue(op2);
        identifierMap.put(id, (char) (val1 | val2));
    }

    @Override
    public void enterLshift(AdventWireParser.LshiftContext ctx) {
        checkCaches();
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = 0, val2 = 0;
        try {
            val1 = getValue(op1);
            val2 = getValue(op2);
            identifierMap.put(id, (char) (val1 << val2));
        } catch (NullPointerException npe) {
            lshiftCache.add(ctx);
        }
    }

    private void lshift(AdventWireParser.LshiftContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = getValue(op1);
        char val2 = getValue(op2);
        identifierMap.put(id, (char) (val1 << val2));
    }

    @Override
    public void enterRshift(AdventWireParser.RshiftContext ctx) {
        checkCaches();
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = 0, val2 = 0;
        try {
            val1 = getValue(op1);
            val2 = getValue(op2);
            identifierMap.put(id, (char) (val1 >> val2));
        } catch (NullPointerException npe) {
            rshiftCache.add(ctx);
        }
    }

    private void rshift(AdventWireParser.RshiftContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op1 = ctx.operand(0);
        AdventWireParser.OperandContext op2 = ctx.operand(1);
        char val1 = getValue(op1);
        char val2 = getValue(op2);
        identifierMap.put(id, (char) (val1 >> val2));
    }

    @Override
    public void enterNot(AdventWireParser.NotContext ctx) {
        checkCaches();
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op = ctx.operand();
        char val1 = 0;
        try {
            val1 = getValue(op);
            identifierMap.put(id, (char) (~val1));
        } catch (NullPointerException npe) {
            notCache.add(ctx);
        }
    }

    private void not(AdventWireParser.NotContext ctx) {
        String id = ctx.IDENTIFIER().getText();
        AdventWireParser.OperandContext op = ctx.operand();
        char value = getValue(op);
        identifierMap.put(id, (char) (~value));
    }

    private boolean checkCaches() {
        List<AdventWireParser.AssignContext> clearAssignCache = new ArrayList<>();
        for (AdventWireParser.AssignContext assignContext : assignCache) {
            try {
                assign(assignContext);
                clearAssignCache.add(assignContext);
            } catch (NullPointerException npe) {
            }
        }
        assignCache.removeAll(clearAssignCache);
        List<AdventWireParser.AndContext> clearAndCache = new ArrayList<>();
        for (AdventWireParser.AndContext andContext : andCache) {
            try {
                and(andContext);
                clearAndCache.add(andContext);
            } catch (NullPointerException npe) {
            }
        }
        andCache.removeAll(clearAndCache);
        List<AdventWireParser.OrContext> clearOrCache = new ArrayList<>();
        for (AdventWireParser.OrContext orContext : orCache) {
            try {
                or(orContext);
                clearOrCache.add(orContext);
            } catch (NullPointerException npe) {
            }
        }
        orCache.removeAll(clearOrCache);
        List<AdventWireParser.LshiftContext> clearLshiftCache = new ArrayList<>();
        for (AdventWireParser.LshiftContext lshiftContext : lshiftCache) {
            try {
                lshift(lshiftContext);
                clearLshiftCache.add(lshiftContext);
            } catch (NullPointerException npe) {
            }
        }
        lshiftCache.removeAll(clearLshiftCache);
        List<AdventWireParser.RshiftContext> clearRshiftCache = new ArrayList<>();
        for (AdventWireParser.RshiftContext rshiftContext : rshiftCache) {
            try {
                rshift(rshiftContext);
                clearRshiftCache.add(rshiftContext);
            } catch (NullPointerException npe) {
            }
        }
        rshiftCache.removeAll(clearRshiftCache);
        List<AdventWireParser.NotContext> clearNotCache = new ArrayList<>();
        for (AdventWireParser.NotContext notContext : notCache) {
            try {
                not(notContext);
                clearNotCache.add(notContext);
            } catch (NullPointerException npe) {
            }
        }
        notCache.removeAll(clearNotCache);
        return assignCache.size() > 0 || andCache.size() > 0 || orCache.size() > 0 || lshiftCache.size() > 0 || rshiftCache.size() > 0 || notCache.size() > 0;
    }

    private char getValue(AdventWireParser.OperandContext opCtx) {
        if (opCtx.IDENTIFIER() != null) {
            return identifierMap.get(opCtx.IDENTIFIER().getText());
        } else {
            return (char) Integer.parseInt(opCtx.INTEGER().getText());
        }
    }
}
