package org.mapledpmlab.type.skill.attackskill.zero;

public class WindCutterTornado extends AssistSkill {
    public WindCutterTornado() {
        this.setName("윈드 커터(소용돌이)");
        this.setAttackCount(3L);
        this.setDamage(175.0 + 30);
        this.setDotDuration(2000L);
        this.setInterval(500L);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
