package com.ethanco.anno;


public enum Finder {
    ACTIVITY {
        @Override
        public String setActivityTrans(Transition trans) {
            StringBuilder sb = new StringBuilder();
            sb.append("if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {\n");
            sb.append("target.getWindow().setEnterTransition(").append(trans.getTrans()).append(");\n");
            sb.append("target.getWindow().setExitTransition(").append(trans.getTrans()).append(");\n");
            sb.append("}\n");
            return sb.toString();
        }

        @Override
        public String setEnterTrans(Transition trans) {
            StringBuilder sb = new StringBuilder();
            sb.append("if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {\n");
            sb.append("target.getWindow().setEnterTransition(").append(trans.getTrans()).append(");\n");
            sb.append("}\n");
            return sb.toString();
        }

        @Override
        public String setExitTrans(Transition trans) {
            StringBuilder sb = new StringBuilder();
            sb.append("if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {\n");
            sb.append("target.getWindow().setExitTransition(").append(trans.getTrans()).append(");\n");
            sb.append("}\n");
            return sb.toString();
        }
    };

    public abstract String setActivityTrans(Transition trans);

    public abstract String setEnterTrans(Transition trans);

    public abstract String setExitTrans(Transition trans);
}
