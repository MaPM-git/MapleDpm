package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.old.skill.buffskill.eunwol.SoulSplitterBuff;

public class SoulSplitter extends AttackSkill {
    public SoulSplitter() {
        this.setName("분혼 격참");
        this.setDamage(2040.0);
        this.setAttackCount(1L);
        this.setDelayByAttackSpeed(1065L);
        this.setRelatedSkill(new SoulSplitterBuff());
    }
}
