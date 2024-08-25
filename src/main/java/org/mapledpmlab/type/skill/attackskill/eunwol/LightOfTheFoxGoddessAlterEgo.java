package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightOfTheFoxGoddessAlterEgo extends AttackSkill {
    public LightOfTheFoxGoddessAlterEgo() {
        this.setName("환혼요호진(여우신의 분신 현현)");
        this.setAttackCount(7L);
        this.setDamage(330.0);
        this.setDelay(900L);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setRelatedSkill(new FoxSun());
    }
}
