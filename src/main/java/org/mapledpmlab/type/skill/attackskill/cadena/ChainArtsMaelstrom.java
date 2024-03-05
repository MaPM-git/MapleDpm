package org.mapledpmlab.type.skill.attackskill.cadena;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChainArtsMaelstrom extends AttackSkill {
    public ChainArtsMaelstrom() {
        this.setName("체인아츠:메일스트롬");
        this.setDelay(720L);
        this.setDamage(660.0);
        this.setAttackCount(4L);
        this.setDotDuration(8000L);
        this.addFinalDamage(1.6);           // 코어강화
        this.setCooldown(3.5);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(390L);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(720L);
        this.getMultiAttackInfo().add(930L);
    }
}
