package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexSandStormKeydown extends AttackSkill implements HexSkill {
    public HexSandStormKeydown() {
        this.setName("헥스 : 샌드스톰(키다운)");
        this.setAttackCount(15L);
        this.setDamage(770.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setDotDuration(2700L);
        this.setInterval(90L);
        this.setLimitAttackCount(30L);
        this.setDelay(2940L);
        this.setRelatedSkill(new HexSandStormSlash());
    }
}
